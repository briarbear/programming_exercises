package others.scan_port;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class GetLocalIp {

	public static List<InetAddress> getAddresses() {
		List<InetAddress> addresses = new ArrayList<InetAddress>();
		Enumeration<NetworkInterface> enumerationNI = null;

		try {
			enumerationNI = NetworkInterface.getNetworkInterfaces();// 得到机器上的所有接口。如果在此机器上找不到任何网络接口，返回null
		} catch (SocketException e) {
			e.printStackTrace();
		}

		while (enumerationNI != null && enumerationNI.hasMoreElements()) {// 遍历每一个接口

			NetworkInterface ni = enumerationNI.nextElement();// 接收每一个网络接口
			try {
				if (!ni.isLoopback() && ni.isUp() && !ni.isVirtual()
						&& !ni.getDisplayName().toString().contains("VMware")
						&& !ni.getDisplayName().toString().contains("VirtualBox")) {// 排除掉虚拟网卡

					Enumeration<InetAddress> enumerationIA = ni.getInetAddresses();// 读取网络接口内的地址信息

					while (enumerationIA.hasMoreElements()) {
						InetAddress ia = enumerationIA.nextElement();
						if (!ia.isLoopbackAddress() && !ia.isLinkLocalAddress() && !ia.isMulticastAddress()) {// 排除掉本地回环
							addresses.add(ia);// 添加到Set集合中
						}
					}
				}
			} catch (SocketException e) {
				e.printStackTrace();
			}
		}

		return addresses;
	}

	public static List<String> getIps() {// 得到Ip地址

		List<InetAddress> addresses = getAddresses();
		List<String> result = new ArrayList<String>();
		for (InetAddress inetAddress : addresses) {
			if (inetAddress != null && inetAddress.getHostAddress().length() < 16) {// 排除掉ipv6
				result.add(inetAddress.getHostAddress().toString());
			}
		}
		return result;

	}

	public static void main(String[] args) {

		// new GetLocalIp();
		List<String> ips = GetLocalIp.getIps();
		for (String string : ips) {
			if (string.length() < 16 && string.length() != 0) {
				System.out.print(string);
			}
		}
	}
}
