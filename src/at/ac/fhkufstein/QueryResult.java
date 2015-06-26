/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.ac.fhkufstein;

/**
 *
 * @author mikevinmike
 */
public class QueryResult {

    private int docId;
    private double score;

    public QueryResult(int docId, double score) {
        this.docId = docId;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Query Result:\tdoc# " + this.docId + "\tscore: " + this.score;
    }
}
