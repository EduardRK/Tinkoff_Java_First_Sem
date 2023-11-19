package edu.project3.Utils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MagicNumber")
public final class StatusCode {
    public static final Map<Object, String> STATUS_CODE = new HashMap<>();

    static {
        STATUS_CODE.put(100, "Continue");
        STATUS_CODE.put(101, "Switching Protocols");
        STATUS_CODE.put(102, "Processing");
        STATUS_CODE.put(103, "Early Hints");
        STATUS_CODE.put(200, "OK");
        STATUS_CODE.put(201, "Created");
        STATUS_CODE.put(202, "Accepted");
        STATUS_CODE.put(203, "Non-Authoritative Information");
        STATUS_CODE.put(204, "No Content");
        STATUS_CODE.put(205, "Reset Content");
        STATUS_CODE.put(206, "Partial Content");
        STATUS_CODE.put(207, "Multi-Status");
        STATUS_CODE.put(208, "Already Reported");
        STATUS_CODE.put(226, "IM Used");
        STATUS_CODE.put(300, "Multiple Choices");
        STATUS_CODE.put(301, "Moved Permanently");
        STATUS_CODE.put(302, "Found");
        STATUS_CODE.put(303, "See Other");
        STATUS_CODE.put(304, "Not Modified");
        STATUS_CODE.put(305, "Use Proxy");
        STATUS_CODE.put(306, "Switch Proxy");
        STATUS_CODE.put(307, "Temporary Redirect");
        STATUS_CODE.put(308, "Permanent Redirect");
        STATUS_CODE.put(400, "Bad Request");
        STATUS_CODE.put(401, "Unauthorized");
        STATUS_CODE.put(402, "Payment Required");
        STATUS_CODE.put(403, "Forbidden");
        STATUS_CODE.put(404, "Not Found");
        STATUS_CODE.put(405, "Method Not Allowed");
        STATUS_CODE.put(406, "Not Acceptable");
        STATUS_CODE.put(407, "Proxy Authentication Required");
        STATUS_CODE.put(408, "Request Timeout");
        STATUS_CODE.put(409, "Conflict");
        STATUS_CODE.put(410, "Gone");
        STATUS_CODE.put(411, "Length Required");
        STATUS_CODE.put(412, "Precondition Failed");
        STATUS_CODE.put(413, "Payload Too Large");
        STATUS_CODE.put(414, "URI Too Long");
        STATUS_CODE.put(415, "Unsupported Media Type");
        STATUS_CODE.put(416, "Range Not Satisfiable");
        STATUS_CODE.put(417, "Expectation Failed");
        STATUS_CODE.put(418, "I'm a teapot");
        STATUS_CODE.put(421, "Misdirected Request");
        STATUS_CODE.put(422, "Unprocessable Entity");
        STATUS_CODE.put(423, "Locked");
        STATUS_CODE.put(424, "Failed Dependency");
        STATUS_CODE.put(425, "Too Early");
        STATUS_CODE.put(426, "Upgrade Required");
        STATUS_CODE.put(428, "Precondition Required");
        STATUS_CODE.put(429, "Too Many Requests");
        STATUS_CODE.put(431, "Request Header Fields Too Large");
        STATUS_CODE.put(451, "Unavailable For Legal Reasons");
        STATUS_CODE.put(500, "Internal Server Error");
        STATUS_CODE.put(501, "Not Implemented");
        STATUS_CODE.put(502, "Bad Gateway");
        STATUS_CODE.put(503, "Service Unavailable");
        STATUS_CODE.put(504, "Gateway Timeout");
        STATUS_CODE.put(505, "HTTP Version Not Supported");
        STATUS_CODE.put(506, "Variant Also Negotiates");
        STATUS_CODE.put(507, "Insufficient Storage");
        STATUS_CODE.put(508, "Loop Detected");
        STATUS_CODE.put(510, "Not Extended");
        STATUS_CODE.put(511, "Network Authentication Required");

    }

    private StatusCode() {
    }
}
