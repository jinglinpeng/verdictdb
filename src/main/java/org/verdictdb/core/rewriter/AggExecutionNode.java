package org.verdictdb.core.rewriter;

import java.util.ArrayList;
import java.util.List;

/**
 * Will be used to handle nested queries (i.e., the queries including aggregate queries as subqueries).
 * 
 * @author Yongjoo Park
 *
 */
public class AggExecutionNode {
  
  List<AggColumn> aggColumns = new ArrayList<>();
  
  

}

class AggColumn {
  
  String aliasName;
  
  String aggType;   // one of "sum", "count", or "avg"
  
  public static AggColumn of(String aliasName, String aggType) {
    AggColumn a = new AggColumn();
    a.aliasName = aliasName;
    a.aggType = aggType;
    return a;
  }
  
}
