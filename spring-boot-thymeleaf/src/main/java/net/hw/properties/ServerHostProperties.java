package net.hw.properties;  
  
import org.springframework.boot.context.properties.ConfigurationProperties;  
import org.springframework.stereotype.Component;  
  
/** 
 * Created by howard on 2017/4/27. 
 */  
@Component  
@ConfigurationProperties("serverhost")    //如果application.yaml serverhost------>serverHost,此处也改为serverHost，则启动出错
public class ServerHostProperties {  
    private InetAddress inetAddressA;  
    private InetAddress inetAddressB;  
    private InetAddress inetAddressC;  
  
    public static class InetAddress {  
        private String ip;  
        private int length;  
        private int port;  
  
        public String getIp() {  
            return ip;  
        }  
  
        public void setIp(String ip) {  
            this.ip = ip;  
        }  
  
        public int getLength() {  
            return length;  
        }  
  
        public void setLength(int length) {  
            this.length = length;  
        }  
  
        public int getPort() {  
            return port;  
        }  
  
        public void setPort(int port) {  
            this.port = port;  
        }  
    }  
  
    public InetAddress getInetAddressA() {  
        return inetAddressA;  
    }  
  
    public void setInetAddressA(InetAddress inetAddressA) {  
        this.inetAddressA = inetAddressA;  
    }  
  
    public InetAddress getInetAddressB() {  
        return inetAddressB;  
    }  
  
    public void setInetAddressB(InetAddress inetAddressB) {  
        this.inetAddressB = inetAddressB;  
    }  
  
    public InetAddress getInetAddressC() {  
        return inetAddressC;  
    }  
  
    public void setInetAddressC(InetAddress inetAddressC) {  
        this.inetAddressC = inetAddressC;  
    }  
}  
