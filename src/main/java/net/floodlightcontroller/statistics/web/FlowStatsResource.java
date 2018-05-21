package net.floodlightcontroller.statistics.web;

import net.floodlightcontroller.statistics.IStatisticsService;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlowStatsResource extends ServerResource {
    private static final Logger log = LoggerFactory.getLogger(FlowStatsResource.class);

    @Get("json")
    public Object retrieve() {
        IStatisticsService statisticsService = (IStatisticsService) getContext().getAttributes().get(IStatisticsService.class.getCanonicalName());
        return statisticsService.getFlowStatistics();
    }
}
