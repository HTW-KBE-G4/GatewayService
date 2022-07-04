package de.tanukihardwarestore.GatewayService.services.results;

import de.tanukihardwarestore.GatewayService.model.PCComponent;

import java.util.ArrayList;
import java.util.List;

public class ComponentQueueResult {

    private List<PCComponent> pcComponentList;

    public ComponentQueueResult(List<PCComponent> pcComponentList) {
        this.pcComponentList = new ArrayList<>(pcComponentList);
    }

    public List<PCComponent> getPcComponentList() {
        return pcComponentList;
    }
}
