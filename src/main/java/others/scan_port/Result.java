package others.scan_port;

import java.util.List;

/**
 * 处理结果类  保存每一个ip及端口扫描结果
 *
 */
public class Result {
	private String ip = null; //ip
	private List<String> ports = null; //端口

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<String> getPorts() {
		return ports;
	}

	public void setPorts(List<String> ports) {
		this.ports = ports;
	}

	@Override
	public String toString() {
		String port = "";
		for (String string : ports) {
			port = port + string + " " ;
		}
		return "Result [ip=" + ip + ", ports=" + port + "]";
	}

}
