/**
 * 
 */
package com.journaldev.jmx;

/**
 * @author cams7
 *
 */
import java.io.IOException;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class SystemConfigClient {

	public static final String HOST = "192.168.0.150";
	public static final String PORT = "1234";

	public static void main(String[] args) throws IOException,
			MalformedObjectNameException {
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://"
				+ HOST + ":" + PORT + "/jmxrmi");

		JMXConnector jmxConnector = null;
		try {
			jmxConnector = JMXConnectorFactory.connect(url);
			MBeanServerConnection mbeanServerConnection = jmxConnector
					.getMBeanServerConnection();
			// ObjectName should be same as your MBean name
			ObjectName mbeanName = new ObjectName(
					"com.journaldev.jmx:type=SystemConfig");

			// Get MBean proxy instance that will be used to make calls to
			// registered MBean
			SystemConfigMBean mbeanProxy = (SystemConfigMBean) MBeanServerInvocationHandler
					.newProxyInstance(mbeanServerConnection, mbeanName,
							SystemConfigMBean.class, true);

			// let's make some calls to mbean through proxy and see the results.
			System.out
					.println("Current SystemConfig::" + mbeanProxy.doConfig());

			mbeanProxy.setSchemaName("NewSchema");
			mbeanProxy.setThreadCount(5);

			System.out.println("New SystemConfig::" + mbeanProxy.doConfig());

			// let's terminate the mbean by making thread count as 0
			mbeanProxy.setThreadCount(0);
		} finally {
			if (jmxConnector != null)
				// close the connection
				jmxConnector.close();
		}
	}

}
