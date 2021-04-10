package ForYouShipment.Search;

import java.util.List;

import ForYouShipment.Models.Journey;

public class AndCriteriaJ implements Criteria<Journey> {

    private Criteria<Journey> criteria;
    private Criteria<Journey> otherCriteria;

    public AndCriteriaJ(Criteria<Journey> criteria, Criteria<Journey> otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
        List<Journey> firstCriteria = criteria.meetCriteria(Journeys, query);
        return otherCriteria.meetCriteria(firstCriteria, query);
    }
}
