package net.hw.webmvc.controller;

 

import net.hw.properties.ServerHostProperties;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * Created by howard on 2017/4/27. 
 */  
@Controller  
public class ServerHostController {  
    @Autowired  
    private ServerHostProperties serverHostProperties;  
  
    @RequestMapping("/showServerHost")  
    public String serverHost(Model model) {  
        List<ServerHostProperties.InetAddress> inetAddresses = new ArrayList<ServerHostProperties.InetAddress>();  
        inetAddresses.add(serverHostProperties.getInetAddressA());  
        inetAddresses.add(serverHostProperties.getInetAddressB());  
        inetAddresses.add(serverHostProperties.getInetAddressC());  
        model.addAttribute("inetAddresses", inetAddresses);  
        return "showServerHost";  
    }  
}  