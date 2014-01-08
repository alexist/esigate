/* 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.esigate.http;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.RequestLine;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.esigate.api.ContainerRequestMediator;

/**
 * Represents an incoming http request.
 * 
 * @author fxbonnet
 * 
 */
public class IncomingRequest extends BasicHttpEntityEnclosingRequest {

    private final Map<String, Object> attributes = new HashMap<String, Object>();
    private final ContainerRequestMediator mediator;
    private String remoteUser;
    private String remoteAddr;
    private String sessionId;
    private Principal userPrincipal;

    public IncomingRequest(RequestLine requestline, ContainerRequestMediator mediator) {
        super(requestline);
        this.mediator = mediator;
    }

    public <T> T getAttribute(String name) {
        return (T) attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public ContainerRequestMediator getMediator() {
        return mediator;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setUserPrincipal(Principal userPrincipal) {
        this.userPrincipal = userPrincipal;
    }

    public Principal getUserPrincipal() {
        return userPrincipal;
    }

}
