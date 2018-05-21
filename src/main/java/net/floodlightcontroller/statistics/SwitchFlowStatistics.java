package net.floodlightcontroller.statistics;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.floodlightcontroller.statistics.web.SwitchFlowStatisticsSerializer;
import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.U64;

@JsonSerialize(using=SwitchFlowStatisticsSerializer.class)
public class SwitchFlowStatistics {
    private DatapathId id;
    private U64 packetCount;
    private U64 byteCount;
    private long durationSec;
    private double portPacketGrow_Inabsolute;
    private long portPacketGrow_Absolute;
    private long portByteCount;

    static U64 packetCount_Mid;
    static private U64 byteCount_Mid;
    static private long durationSec_Mid;

    private SwitchFlowStatistics() {
    }

    private SwitchFlowStatistics(DatapathId d, U64 pc, U64 bc, long ds) {
        id = d;
        packetCount = pc;
        byteCount = bc;
        durationSec = ds;
    }

    public static SwitchFlowStatistics of(DatapathId d, U64 pc, U64 bc, long ds) {
        if (d == null) {
            throw new IllegalArgumentException("Datapath ID cannot be null");
        }
        if (pc == null) {
            throw new IllegalArgumentException("PacketCount cannot be null");
        }
        if (bc == null) {
            throw new IllegalArgumentException("ByteCount speed cannot be null");
        }

        return new SwitchFlowStatistics(d, pc, bc, ds);
    }

    public DatapathId getSwitchId() {
        return id;
    }

    public U64 getPacketCountMatched() {
        return packetCount;
    }

    public U64 getByteCountMatched() {
        return byteCount;
    }

    public long getDurationSec() {
        return durationSec;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        //result = prime * result + ((pt == null) ? 0 : pt.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SwitchFlowStatistics other = (SwitchFlowStatistics) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        /*if (pt == null) {
            if (other.pt != null)
                return false;
        } else if (!pt.equals(other.pt))
            return false;*/
        return true;
    }

}
