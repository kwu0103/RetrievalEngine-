package com.TeamHotel.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.TeamHotel.inverindex.Index;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.jetbrains.annotations.NotNull;

public class Clustering {

    /**
     * clusterDocuments should use a clustering algorithm to assign each document to a cluster.
     * @param idx - The index containing each of the documents.  Cluster info should be added to this index using the provided functions.
     * @param maxClusteringRepititions - The max number of repititions of the clustering algorithm to use.  Using fewer is also fine.
     * @param maxDocuments
     * @param offset
     * @return 
     */
    public static int clusterDocuments(@NotNull final Index idx, int maxClusteringRepititions, int offset, int maxDocuments) {
        // example code that might be helpful.
        int num = idx.getNumDocuments();
        int randomNum = RandomUtils.nextInt(0, num);
        Optional<Pair<String, ArrayList<Double>>> randomDocIdAndVector = idx.getDocumentVectorByIndex(randomNum);
        int clusterId = 1;

        Iterator<Pair<Integer, ArrayList<Double>>> leaderIterator = idx.getClusterLeaders();
        Iterator<Integer> clusterIterator = idx.getClusters();
        Iterator<Pair<String, ArrayList<Double>>> documentsInCluster = idx.getDocumentsInCluster(clusterId); // maximum documents to retrieve
        Iterator<Triple<String, Integer, ArrayList<Double>>> documentIterator = idx.getAllDocuments(0, 100000000); // documents to skip (offset), max documents to retrieve


        ArrayList<Double> docVector = new ArrayList<>(WordSimilarity.numDimensions);

        idx.addFakeLeader(clusterId, docVector);

        String docId = "asfvwevwtbvqeVQr";
        clusterId = 2;
        idx.setDocumentClass(docId, clusterId);

        return 0;
        
    }

    /**
     * query 
     * @param idx - The index containing the clustered documents
     * @param query - A list of query terms
     * @param resultsPerQuery - The maximum number of query results.  For TREC-Y3 we can return up to 20 results per query.
     * @return A list of documents and their scores.
     *            The list length should be at most <resultsPerQuery>
     *            The Pair<String, Double> should contain the Document ID, and the Document Score.
     */
    public static List<Pair<String, Double>> query(Index idx, @NotNull final List<String> query, int resultsPerQuery) {
        List<Pair<String, Double>> results = new LinkedList<>();

        // example
        String docId = "rvqWRVAVWetbVWEqw"; // the trec id
        double score = 0.54;
        results.add(Pair.of(docId, score));
        return results;
    }

}
