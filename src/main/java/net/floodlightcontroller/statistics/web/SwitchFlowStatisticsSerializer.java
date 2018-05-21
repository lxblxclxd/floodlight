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
        jGen.writeStringField("durSecond", String.valueOf(sfs.getDurationSec()));
        jGen.writeEndObject();
    }

}
