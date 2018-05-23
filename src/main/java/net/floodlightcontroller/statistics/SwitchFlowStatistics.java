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

    private SwitchFlowStatistics(DatapathId d, U64 pc, U64 bc, long ds, Match m) {
        id = d;
        packetCount = pc;
        byteCount = bc;
        durationSec = ds;
        ipv4Src = getMatchFieldIfSupport(m, MatchField.IPV4_SRC);
        ipv4Dst = getMatchFieldIfSupport(m, MatchField.IPV4_DST);
        ipv6Src = getMatchFieldIfSupport(m, MatchField.IPV6_SRC);
        ipv6Dst = getMatchFieldIfSupport(m, MatchField.IPV6_DST);
        tcpFlag = getMatchFieldIfSupport(m, MatchField.TCP_FLAGS);
        icmpv4Code = getMatchFieldIfSupport(m, MatchField.ICMPV4_CODE);
        icmpv4Type = getMatchFieldIfSupport(m, MatchField.ICMPV4_TYPE);
        icmpv6Code = getMatchFieldIfSupport(m, MatchField.ICMPV6_CODE);
        icmpv6Type = getMatchFieldIfSupport(m, MatchField.ICMPV6_TYPE);
        udpSrc = getMatchFieldIfSupport(m, MatchField.UDP_SRC);
        udpDst = getMatchFieldIfSupport(m, MatchField.UDP_DST);
    }

    private <F extends OFValueType<F>> F getMatchFieldIfSupport(Match m, MatchField<F> field) {
        if (m.supports(field)) {
            System.out.println(m.get(field));
            return m.get(field);
        }
        else return null;
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

}
