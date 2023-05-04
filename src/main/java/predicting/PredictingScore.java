package predicting;

import java.net.ProtocolException;

public interface PredictingScore {
    public StringBuffer predictScore(String teamA, String teamB) throws Exception;
}
