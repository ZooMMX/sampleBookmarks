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
	        .append("----------------------------------------------------").append("<br />")
	        .append("HARDWARE INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />")
	        .append("Serial Number     :  " + SystemInfo.getSerial()).append("<br />")
	        .append("CPU Revision      :  " + SystemInfo.getCpuRevision()).append("<br />")
	        .append("CPU Architecture  :  " + SystemInfo.getCpuArchitecture()).append("<br />")
	        .append("CPU Part          :  " + SystemInfo.getCpuPart()).append("<br />")
	        .append("CPU Temperature   :  " + SystemInfo.getCpuTemperature()).append("<br />")
	        .append("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage()).append("<br />")
	        .append("MIPS              :  " + SystemInfo.getBogoMIPS()).append("<br />")
	        .append("Processor         :  " + SystemInfo.getProcessor()).append("<br />")
	        .append("Hardware Revision :  " + SystemInfo.getRevision()).append("<br />")
	        .append("Is Hard Float ABI :  " + SystemInfo.isHardFloatAbi()).append("<br />")
	        .append("Board Type        :  " + SystemInfo.getBoardType().name()).append("<br />")
        
	        .append("----------------------------------------------------").append("<br />")
	        .append("MEMORY INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />")
	        .append("Total Memory      :  " + SystemInfo.getMemoryTotal()).append("<br />")
	        .append("Used Memory       :  " + SystemInfo.getMemoryUsed()).append("<br />")
	        .append("Free Memory       :  " + SystemInfo.getMemoryFree()).append("<br />")
	        .append("Shared Memory     :  " + SystemInfo.getMemoryShared()).append("<br />")
	        .append("Memory Buffers    :  " + SystemInfo.getMemoryBuffers()).append("<br />")
	        .append("Cached Memory     :  " + SystemInfo.getMemoryCached()).append("<br />")
	        .append("SDRAM_C Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_C()).append("<br />")
	        .append("SDRAM_I Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_I()).append("<br />")
	        .append("SDRAM_P Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_P()).append("<br />")

	        .append("----------------------------------------------------").append("<br />")
	        .append("OPERATING SYSTEM INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />")
	        .append("OS Name           :  " + SystemInfo.getOsName()).append("<br />")
	        .append("OS Version        :  " + SystemInfo.getOsVersion()).append("<br />")
	        .append("OS Architecture   :  " + SystemInfo.getOsArch()).append("<br />")
	        .append("OS Firmware Build :  " + SystemInfo.getOsFirmwareBuild()).append("<br />")
	        .append("OS Firmware Date  :  " + SystemInfo.getOsFirmwareDate()).append("<br />")
        
	        .append("----------------------------------------------------").append("<br />")
	        .append("JAVA ENVIRONMENT INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />")
	        .append("Java Vendor       :  " + SystemInfo.getJavaVendor()).append("<br />")
	        .append("Java Vendor URL   :  " + SystemInfo.getJavaVendorUrl()).append("<br />")
	        .append("Java Version      :  " + SystemInfo.getJavaVersion()).append("<br />")
	        .append("Java VM           :  " + SystemInfo.getJavaVirtualMachine()).append("<br />")
	        .append("Java Runtime      :  " + SystemInfo.getJavaRuntime()).append("<br />")
        
	        .append("----------------------------------------------------").append("<br />")
	        .append("CODEC INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />")
	        .append("H264 Codec Enabled:  " + SystemInfo.getCodecH264Enabled()).append("<br />")
	        .append("MPG2 Codec Enabled:  " + SystemInfo.getCodecMPG2Enabled()).append("<br />")
	        .append("WVC1 Codec Enabled:  " + SystemInfo.getCodecWVC1Enabled()).append("<br />")

	        .append("----------------------------------------------------").append("<br />")
	        .append("CLOCK INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />")
	        .append("ARM Frequency     :  " + SystemInfo.getClockFrequencyArm()).append("<br />")
	        .append("CORE Frequency    :  " + SystemInfo.getClockFrequencyCore()).append("<br />")
	        .append("H264 Frequency    :  " + SystemInfo.getClockFrequencyH264()).append("<br />")
	        .append("ISP Frequency     :  " + SystemInfo.getClockFrequencyISP()).append("<br />")
	        .append("V3D Frequency     :  " + SystemInfo.getClockFrequencyV3D()).append("<br />")
	        .append("UART Frequency    :  " + SystemInfo.getClockFrequencyUART()).append("<br />")
	        .append("PWM Frequency     :  " + SystemInfo.getClockFrequencyPWM()).append("<br />")
	        .append("EMMC Frequency    :  " + SystemInfo.getClockFrequencyEMMC()).append("<br />")
	        .append("Pixel Frequency   :  " + SystemInfo.getClockFrequencyPixel()).append("<br />")
	        .append("VEC Frequency     :  " + SystemInfo.getClockFrequencyVEC()).append("<br />")
	        .append("HDMI Frequency    :  " + SystemInfo.getClockFrequencyHDMI()).append("<br />")
	        .append("DPI Frequency     :  " + SystemInfo.getClockFrequencyDPI()).append("<br />")
    
	        .append("----------------------------------------------------").append("<br />")
	        .append("NETWORK INFO").append("<br />")
	        .append("----------------------------------------------------").append("<br />");
        
	        // display some of the network information
	        sb.append("Hostname          :  " + NetworkInfo.getHostname()).append("<br />");
	        for (String ipAddress : NetworkInfo.getIPAddresses())
	            sb.append("IP Addresses      :  " + ipAddress).append("<br />");
	        for (String fqdn : NetworkInfo.getFQDNs())
	            sb.append("FQDN              :  " + fqdn).append("<br />");
	        for (String nameserver : NetworkInfo.getNameservers())
	            sb.append("Nameserver        :  " + nameserver);

	        m.put("infoData", sb.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
