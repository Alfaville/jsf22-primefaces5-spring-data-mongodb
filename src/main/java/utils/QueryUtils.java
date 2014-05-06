package utils;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class QueryUtils {

	public static Query like(String where, String value) {
		Query query = Query.query(Criteria.where(where).regex("[\\w]*" + value + "[\\w]*", "i"));
		return query;
	}

}
