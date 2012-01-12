/*
 * Copyright (c) 2005, salesforce.com, inc.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 *    Redistributions of source code must retain the above copyright notice, this list of conditions and the 
 *    following disclaimer.
 *  
 *    Redistributions in binary form must reproduce the above copyright notice, this list of conditions and 
 *    the following disclaimer in the documentation and/or other materials provided with the distribution. 
 *    
 *    Neither the name of salesforce.com, inc. nor the names of its contributors may be used to endorse or 
 *    promote products derived from this software without specific prior written permission.
 *  
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED 
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR 
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.sforce.ws.transport;

import com.sforce.ws.ConnectorConfig;

import com.sun.jmx.snmp.SnmpString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * This interface defines a Transport.
 *
 * @author http://cheenath.com
 * @version 1.0
 * @since 1.0  Nov 30, 2005
 */
public interface Transport {

    void setConfig(ConnectorConfig config);

    /**
     * Connect to the specified endpoint.
     *
     * @param url endpoint address
     * @param soapAction soap action
     * @return output stream that can be used to send response
     * @throws java.io.IOException failed to connect to the endpoint
     */
    OutputStream connect(String url, String soapAction) throws IOException;

    /**
     * Connect to the specified endpoint.
     *
     * @param url endpoint address
     * @param headers header map
     * @return output stream that can be used to send response
     * @throws java.io.IOException failed to connect to the endpoint
     */
    OutputStream connect(String url, HashMap<String, String> headers) throws IOException;

    /**
     * Connect to the specified endpoint.
     *
     * @param url endpoint address
     * @param headers header map
     * @return output stream that can be used to send response
     * @throws java.io.IOException failed to connect to the endpoint
     */
    OutputStream connect(String url, HashMap<String, String> headers, boolean compress) throws IOException;
    
    /**
     * returns the response from the endpoint. This method must be called after
     * a connect call.
     *
     * @return response or error stream.
     * @throws java.io.IOException failed to get content
     */
    InputStream getContent() throws IOException;

    /**
     * checks whether the response from the remote server is successful or not.
     * @return true if the call was successful
     */
    boolean isSuccessful();

    /**
     * Create a connection
     */
    HttpURLConnection createConnection(String url,HashMap<String, String> httpHeaders) throws IOException;

    /**
     * Create a URL
     */
    URL createURL(String url) throws MalformedURLException;
}
