package org.botien;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {

    static String JASPER_REPORT_URL_REST = "http://localhost:8081/jasperserver/rest_v2/reportExecutions";
    static String JASPER_REPORT_RESOURCE_URL_REST = "http://localhost:8081/jasperserver/rest_v2/reportExecutions/";
    static String REPORT_OUTPUT_RESOURCE_URL = "";

    public static void jasperEmbeddingWithHttpAPI() throws URISyntaxException, IOException {
        String reportServerURL = "http://localhost:8081";

        String username = "jasperadmin";
        String password = "jasperadmin";

        String ParentFolderUri = "reports";
        String reportName = "Project_tickets1";

        Map<String, String> reportParams = new HashMap<>();
        reportParams.put("project_id", "5");

        String reportURL = reportServerURL + "/jasperserver/flow.html?_flowId=viewReportFlow&_flowId=viewReportFlow&ParentFolderUri=%2F" + ParentFolderUri + "&reportUnit=%2F" + ParentFolderUri +
                "%2F" + reportName + "&standAlone=true" +
                "&j_username" + "=" + username + "&j_password=" + password + "&" + concatReportParamsForURL(reportParams) + "output=pdf";

        System.out.println(reportURL);

        URI uriFromString = new URI(reportURL);
        java.awt.Desktop.getDesktop().browse(uriFromString);

    }

    private static String concatReportParamsForURL(Map<String, String> reportParams) {
        StringBuilder concatenatedReportParam = new StringBuilder();

        for (Map.Entry<String, String> reportParam : reportParams.entrySet()) {
            concatenatedReportParam.append(reportParam.getKey()).append("=").append(reportParam.getValue()).append("&");
        }

        return concatenatedReportParam.toString();
    }


    public static void main(String[] args) throws URISyntaxException, IOException {
        jasperEmbeddingWithHttpAPI();
//        jasperEmbeddingWithRESTAPI();
    }
}