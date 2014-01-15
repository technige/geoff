/*
 * Copyright 2013-2014, Nigel Small
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nigelsmall.geoff;

import org.apache.commons.lang.StringUtils;

import java.util.*;

public class Subgraph {

    private ArrayList<String> comments;
    private HashMap<String, AbstractNode> nodes;
    private ArrayList<AbstractRelationship> relationships;

    public Subgraph() {
        super();
        this.comments = new ArrayList<>();
        this.nodes = new HashMap<>();
        this.relationships = new ArrayList<>();
    }

    public int order() {
        return this.nodes.size();
    }

    public int size() {
        return this.relationships.size();
    }

    public List<String> getComments() {
        return this.comments;
    }

    public Map<String, AbstractNode> getNodes() {
        return this.nodes;
    }

    public List<AbstractRelationship> getRelationships() {
        return this.relationships;
    }

    public String toString() {
        ArrayList<String> s = new ArrayList<>();
        for (AbstractNode node : this.nodes.values()) {
            s.add(node.toString());
        }
        for (AbstractRelationship rel : this.relationships) {
            s.add(rel.toString());
        }
        return StringUtils.join(s, "\n");
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public AbstractNode mergeNode(AbstractNode node) {
        if (this.nodes.containsKey(node.getName())) {
            this.nodes.get(node.getName()).mergeNode(node);
        } else {
            this.nodes.put(node.getName(), node);
        }
        return this.nodes.get(node.getName());
    }

    public void addRelationship(AbstractRelationship rel) {
        this.mergeNode(rel.getStartNode());
        this.mergeNode(rel.getEndNode());
        this.relationships.add(rel);
    }

}
