package sin.sin2017.project.StatusInformations;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import sin.sin2017.project.Constants;
import sin.sin2017.project.Status.BlindStatus;
import sin.sin2017.project.Status.LightsStatus;
import sin.sin2017.project.agents.BlindAgent;
import sin.sin2017.project.agents.LightAgent;
import sin.sin2017.project.domoticz.readJson;

import java.io.IOException;

public class BlindStatusInformation extends CyclicBehaviour {
    @Override
    public void action() {
        BlindAgent agent = (BlindAgent) myAgent;
        try{
            readJson readJson = new readJson();
            int percentage = readJson.getPercentage(Integer.parseInt(Constants.BLIND_ID));
            agent.getBlindStatus().percentageOfClose = percentage;
        }catch (Exception e){
            agent.getBlindStatus().percentageOfClose = 0;
            //System.err.println("Error in read status");
        }
    }
}
