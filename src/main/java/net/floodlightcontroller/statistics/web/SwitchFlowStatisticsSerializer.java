package net.floodlightcontroller.statistics.web;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.floodlightcontroller.statistics.SwitchFlowStatistics;

import java.io.IOException;

public class SwitchFlowStatisticsSerializer extends JsonSerializer<SwitchFlowStatistics> {

    @Override
    public void serialize(SwitchFlowStatistics sfs, JsonGenerator jGen, SerializerProvider serializer) throws IOException, JsonProcessingException {
        jGen.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);

        jGen.writeStartObject();
        jGen.writeStringField("switchId", sfs.getSwitchId().toString());
        jGen.writeStringField("packageCount", sfs.getPacketCountMatched().toString());
        jGen.writeStringField("byteCount", sfs.getByteCountMatched().toString());
        jGen.writeStringField("durationSec", String.valueOf(sfs.getDurationSec()));
        if (sfs.getIpv4Src() != null)
            jGen.writeStringField("ipv4Src", sfs.getIpv4Src().toString());
        if (sfs.getIpv4Dst() != null)
            jGen.writeStringField("ipv4Dst", sfs.getIpv4Dst().toString());
        if (sfs.getIpv6Src() != null)
            jGen.writeStringField("ipv6Src", sfs.getIpv6Src().toString());
        if (sfs.getIpv6Dst() != null)
            jGen.writeStringField("ipv6Dst", sfs.getIpv6Dst().toString());
        if (sfs.getTcpFlag() != null)
            jGen.writeStringField("tcpFlag", sfs.getTcpFlag().toString());
        if (sfs.getIcmpv4Code() != null)
            jGen.writeStringField("icmpv4Code", sfs.getIcmpv4Code().toString());
        if (sfs.getIcmpv4Type() != null)
            jGen.writeStringField("icmpv4Type", sfs.getIcmpv4Type().toString());
        if (sfs.getIcmpv6Code() != null)
            jGen.writeStringField("icmpv6Code", sfs.getIcmpv6Code().toString());
        if (sfs.getIcmpv6Type() != null)
            jGen.writeStringField("icmpv6Type", sfs.getIcmpv6Type().toString());
        if (sfs.getUdpSrc() != null)
            jGen.writeStringField("udpSrc", sfs.getUdpSrc().toString());
        if (sfs.getUdpDst() != null)
            jGen.writeStringField("udpDst", sfs.getUdpDst().toString());
        jGen.writeEndObject();
    }

}
