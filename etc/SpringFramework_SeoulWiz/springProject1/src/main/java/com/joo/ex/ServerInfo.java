package com.joo.ex;

public class ServerInfo {
	private String ipNum;
	private String port;
	public String getIpNum() {
		return ipNum;
	}
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "ServerInfo [ipNum=" + ipNum + ", port=" + port + "]";
	}
	
}
