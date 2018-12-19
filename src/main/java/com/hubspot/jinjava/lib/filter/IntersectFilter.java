package com.hubspot.jinjava.lib.filter;

import java.util.ArrayList;
import java.util.Map;

import com.google.common.collect.Sets;
import com.hubspot.jinjava.doc.annotations.JinjavaDoc;
import com.hubspot.jinjava.doc.annotations.JinjavaParam;
import com.hubspot.jinjava.doc.annotations.JinjavaSnippet;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;

@JinjavaDoc(
    value = "Returns a list containing elements present in both lists",
    params = {
        @JinjavaParam(value = "value", type = "sequence", desc = "The first list"),
        @JinjavaParam(value = "list", type = "sequence", desc = "The second list")
    },
    snippets = {
        @JinjavaSnippet(
            code = "{{ [1, 2, 3]|intersect([2, 3, 4]) }}")
    })
public class IntersectFilter extends AbstractSetFilter {

  @Override
  public Object filter(Object var, JinjavaInterpreter interpreter, Object[] args, Map<String, Object> kwargs) {
    return new ArrayList<>(Sets.intersection(objectToSet(var), objectToSet(parseArgs(args))));
  }

  @Override
  public String getName() {
    return "intersect";
  }
}
