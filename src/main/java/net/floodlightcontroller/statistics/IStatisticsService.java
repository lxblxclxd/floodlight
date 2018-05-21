package net.floodlightcontroller.statistics;

import net.floodlightcontroller.core.module.IFloodlightService;
import net.floodlightcontroller.core.types.NodePortTuple;
import org.projectfloodlight.openflow.types.DatapathId;
import org.projectfloodlight.openflow.types.OFPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public interface IStatisticsService extends IFloodlightService {

    public SwitchPortBandwidth getBandwidthConsumption(DatapathId dpid, OFPort p);

    public Map<NodePortTuple, SwitchPortBandwidth> getBandwidthConsumption();

    public List<SwitchFlowStatistics> getFlowStatistics();

    public void collectStatistics(boolean collect);
}
