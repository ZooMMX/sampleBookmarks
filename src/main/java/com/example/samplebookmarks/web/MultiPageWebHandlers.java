package com.example.samplebookmarks.web;

import java.util.Map;

import javax.inject.Inject;

import com.britesnow.snow.web.handler.annotation.WebModelHandler;
import com.britesnow.snow.web.param.annotation.WebModel;
import com.britesnow.snow.web.param.annotation.WebUser;
import com.example.samplebookmarks.dao.ItemDao;
import com.example.samplebookmarks.entity.User;
import com.google.inject.Singleton;

import java.io.IOException;
import java.text.ParseException;

import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;


@Singleton
public class MultiPageWebHandlers {

    @Inject
    private ItemDao itemDao;
    
    @WebModelHandler(startsWith="/")
    public void allPages(@WebModel Map m){
        m.put("version", "0.1.0");
    }
    
    /**
     * 
     * @param m (@WebModel) will be injected by Snow, and it is the WebModel for the page 
     * @param user (@WebUser) will be injected by Snow, and represents the Authenticate user. Null if nobody authenticated.
     */
    @WebModelHandler(startsWith="/bookmarks")
    public void bookmarksPage(@WebModel Map m, @WebUser User user){
        if (user != null){
            m.put("items", itemDao.getItemsForUser(user.getId()));
        }
    }

	@WebModelHandler(startsWith="/info")
    public void infoPage(@WebModel Map m, @WebUser User user){
		try {
			StringBuilder sb = new StringBuilder()
	        .append("----------------------------------------------------")
	        .append("HARDWARE INFO")
	        .append("----------------------------------------------------")
	        .append("Serial Number     :  " + SystemInfo.getSerial())
	        .append("CPU Revision      :  " + SystemInfo.getCpuRevision())
	        .append("CPU Architecture  :  " + SystemInfo.getCpuArchitecture())
	        .append("CPU Part          :  " + SystemInfo.getCpuPart())
	        .append("CPU Temperature   :  " + SystemInfo.getCpuTemperature())
	        .append("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage())
	        .append("MIPS              :  " + SystemInfo.getBogoMIPS())
	        .append("Processor         :  " + SystemInfo.getProcessor())
	        .append("Hardware Revision :  " + SystemInfo.getRevision())
	        .append("Is Hard Float ABI :  " + SystemInfo.isHardFloatAbi())
	        .append("Board Type        :  " + SystemInfo.getBoardType().name())
        
	        .append("----------------------------------------------------")
	        .append("MEMORY INFO")
	        .append("----------------------------------------------------")
	        .append("Total Memory      :  " + SystemInfo.getMemoryTotal())
	        .append("Used Memory       :  " + SystemInfo.getMemoryUsed())
	        .append("Free Memory       :  " + SystemInfo.getMemoryFree())
	        .append("Shared Memory     :  " + SystemInfo.getMemoryShared())
	        .append("Memory Buffers    :  " + SystemInfo.getMemoryBuffers())
	        .append("Cached Memory     :  " + SystemInfo.getMemoryCached())
	        .append("SDRAM_C Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_C())
	        .append("SDRAM_I Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_I())
	        .append("SDRAM_P Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_P())

	        .append("----------------------------------------------------")
	        .append("OPERATING SYSTEM INFO")
	        .append("----------------------------------------------------")
	        .append("OS Name           :  " + SystemInfo.getOsName())
	        .append("OS Version        :  " + SystemInfo.getOsVersion())
	        .append("OS Architecture   :  " + SystemInfo.getOsArch())
	        .append("OS Firmware Build :  " + SystemInfo.getOsFirmwareBuild())
	        .append("OS Firmware Date  :  " + SystemInfo.getOsFirmwareDate())
        
	        .append("----------------------------------------------------")
	        .append("JAVA ENVIRONMENT INFO")
	        .append("----------------------------------------------------")
	        .append("Java Vendor       :  " + SystemInfo.getJavaVendor())
	        .append("Java Vendor URL   :  " + SystemInfo.getJavaVendorUrl())
	        .append("Java Version      :  " + SystemInfo.getJavaVersion())
	        .append("Java VM           :  " + SystemInfo.getJavaVirtualMachine())
	        .append("Java Runtime      :  " + SystemInfo.getJavaRuntime())
        
	        .append("----------------------------------------------------")
	        .append("CODEC INFO")
	        .append("----------------------------------------------------")
	        .append("H264 Codec Enabled:  " + SystemInfo.getCodecH264Enabled())
	        .append("MPG2 Codec Enabled:  " + SystemInfo.getCodecMPG2Enabled())
	        .append("WVC1 Codec Enabled:  " + SystemInfo.getCodecWVC1Enabled())

	        .append("----------------------------------------------------")
	        .append("CLOCK INFO")
	        .append("----------------------------------------------------")
	        .append("ARM Frequency     :  " + SystemInfo.getClockFrequencyArm())
	        .append("CORE Frequency    :  " + SystemInfo.getClockFrequencyCore())
	        .append("H264 Frequency    :  " + SystemInfo.getClockFrequencyH264())
	        .append("ISP Frequency     :  " + SystemInfo.getClockFrequencyISP())
	        .append("V3D Frequency     :  " + SystemInfo.getClockFrequencyV3D())
	        .append("UART Frequency    :  " + SystemInfo.getClockFrequencyUART())
	        .append("PWM Frequency     :  " + SystemInfo.getClockFrequencyPWM())
	        .append("EMMC Frequency    :  " + SystemInfo.getClockFrequencyEMMC())
	        .append("Pixel Frequency   :  " + SystemInfo.getClockFrequencyPixel())
	        .append("VEC Frequency     :  " + SystemInfo.getClockFrequencyVEC())
	        .append("HDMI Frequency    :  " + SystemInfo.getClockFrequencyHDMI())
	        .append("DPI Frequency     :  " + SystemInfo.getClockFrequencyDPI())
    
	        .append("----------------------------------------------------")
	        .append("NETWORK INFO")
	        .append("----------------------------------------------------");
        
	        // display some of the network information
	        sb.append("Hostname          :  " + NetworkInfo.getHostname());
	        for (String ipAddress : NetworkInfo.getIPAddresses())
	            sb.append("IP Addresses      :  " + ipAddress);
	        for (String fqdn : NetworkInfo.getFQDNs())
	            sb.append("FQDN              :  " + fqdn);
	        for (String nameserver : NetworkInfo.getNameservers())
	            sb.append("Nameserver        :  " + nameserver);

	        m.put("infoData", sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
