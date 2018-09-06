package com.isoft.vo;

public class SSocks {
	private int score;
	private String ip;
	private String port;
	private String pwd;
	private String codeType;
	private String timestamp;
	private String nation;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String toString() {
		return "[score=" + score + ",ip=" + ip + ",port=" + port + ",codeType=" + codeType + ",timestamp=" + timestamp
				+ ",nation=" + nation + "]";
	}

}
