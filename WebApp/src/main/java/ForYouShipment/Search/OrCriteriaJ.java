package ForYouShipment.Search;

import java.util.List;

import ForYouShipment.Models.Journey;

public class OrCriteriaJ implements Criteria<Journey>{

    private Criteria<Journey> criteria;
    private Criteria<Journey> otherCriteria;

    public OrCriteriaJ(Criteria<Journey> criteria, Criteria<Journey> otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Journey> meetCriteria(List<Journey> Journeys, String query) {
        List<Journey> firstCriteriaItems = criteria.meetCriteria(Journeys, query);
        List<Journey> otherCriteriaItems = otherCriteria.meetCriteria(Journeys, query);

        for (Journey j: otherCriteriaItems) {
            if (! firstCriteriaItems.contains(j)) {
                firstCriteriaItems.add(j);
            }
        }
        return firstCriteriaItems;
    }
}