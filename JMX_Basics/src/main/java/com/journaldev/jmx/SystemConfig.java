/**
 * 
 */
package com.journaldev.jmx;

/**
 * @author cams7
 *
 */
public class SystemConfig implements SystemConfigMBean {

	private int threadCount;
	private String schemaName;

	/**
	 * @param numThreads
	 * @param schema
	 */
	public SystemConfig(int numThreads, String schema) {
		this.threadCount = numThreads;
		this.schemaName = schema;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.journaldev.jmx.SystemConfigMBean#setThreadCount(int)
	 */
	public void setThreadCount(int noOfThreads) {
		this.threadCount = noOfThreads;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.journaldev.jmx.SystemConfigMBean#getThreadCount()
	 */
	public int getThreadCount() {
		return this.threadCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.journaldev.jmx.SystemConfigMBean#setSchemaName(java.lang.String)
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getSchemaName() {
		return this.schemaName;
	}

	public String doConfig() {
		return "No of Threads=" + this.threadCount + " and DB Schema Name="
				+ this.schemaName;
	}

}
