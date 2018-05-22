package net.floodlightcontroller.statistics;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import net.floodlightcontroller.statistics.web.SwitchFlowStatisticsSerializer;
import org.projectfloodlight.openflow.protocol.match.Match;
import org.projectfloodlight.openflow.protocol.match.MatchField;
import org.projectfloodlight.openflow.types.*;

@JsonSerialize(using = SwitchFlowStatisticsSerializer.class)
public class SwitchFlowStatistics {
    private DatapathId id;
    private U64 packetCount;
    private U64 byteCount;
    private long durationSec;

    private IPv4Address ipv4Src;
    private IPv4Address ipv4Dst;
    private IPv6Address ipv6Src;
    private IPv6Address ipv6Dst;
    private U16 tcpFlag;
    private ICMPv4Code icmpv4Code;
    private ICMPv4Type icmpv4Type;
    private U8 icmpv6Code;
    private U8 icmpv6Type;
    private TransportPort udpSrc;
    private TransportPort udpDst;

    private double portPacketGrow_Inabsolute;
    private long portPacketGrow_Absolute;
    private long portByteCount;

    static U64 packetCount_Mid;
    static private U64 byteCount_Mid;
    static private long durationSec_Mid;

    private SwitchFlowStatistics() {
    }

    private SwitchFlowStatistics(DatapathId d, U64 pc, U64 bc, long ds, Match m) {
        id = d;
        packetCount = pc;
        byteCount = bc;
        durationSec = ds;
        ipv4Src = m.get(MatchField.IPV4_SRC);
        ipv4Dst = m.get(MatchField.IPV4_DST);
        ipv6Src = m.get(MatchField.IPV6_SRC);
        ipv6Dst = m.get(MatchField.IPV6_DST);
        tcpFlag = m.get(MatchField.TCP_FLAGS);
        icmpv4Code = m.get(MatchField.ICMPV4_CODE);
        icmpv4Type = m.get(MatchField.ICMPV4_TYPE);
        icmpv6Code = m.get(MatchField.ICMPV6_CODE);
        icmpv6Type = m.get(MatchField.ICMPV6_TYPE);
        udpSrc = m.get(MatchField.UDP_SRC);
        udpDst = m.get(MatchField.UDP_DST);
    }

    public static SwitchFlowStatistics of(DatapathId d, U64 pc, U64 bc, long ds, Match m) {
        if (d == null) {
            throw new IllegalArgumentException("Datapath ID cannot be null");
        }
        if (pc == null) {
            throw new IllegalArgumentException("PacketCount cannot be null");
        }
        if (bc == null) {
            throw new IllegalArgumentException("ByteCount cannot be null");
        }
        if (m == null) {
            throw new IllegalArgumentException("Match cannot be null");
        }

        return new SwitchFlowStatistics(d, pc, bc, ds, m);
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

    public IPv4Address getIpv4Src() {
        return ipv4Src;
    }

    public IPv4Address getIpv4Dst() {
        return ipv4Dst;
    }

    public IPv6Address getIpv6Src() {
        return ipv6Src;
    }

    public IPv6Address getIpv6Dst() {
        return ipv6Dst;
    }


    public U16 getTcpFlag() {
        return tcpFlag;
    }

    public ICMPv4Code getIcmpv4Code() {
        return icmpv4Code;
    }

    public ICMPv4Type getIcmpv4Type() {
        return icmpv4Type;
    }

    public U8 getIcmpv6Code() {
        return icmpv6Code;
    }

    public U8 getIcmpv6Type() {
        return icmpv6Type;
    }

    public TransportPort getUdpSrc() {
        return udpSrc;
    }

    public TransportPort getUdpDst() {
        return udpDst;
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
