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

package org.esigate.api;

import java.io.IOException;
import java.io.Serializable;

import org.apache.http.HttpResponse;
import org.apache.http.cookie.Cookie;
import org.esigate.http.IncomingRequest;

/**
 * Encapsulates all interactions between EsiGate and the server container it is running in. To run EsiGate inside a new
 * container type, an implementation of this interface is required.
 * 
 * @author Francois-Xavier Bonnet
 * 
 */
public interface ContainerRequestMediator {

    /**
     * Retrieves the cookies from the Cookie header of the request.
     * 
     * @return the cookies contained in the incoming request
     */
    Cookie[] getCookies();

    /**
     * Sends a cookie to the client by adding a Set-cookie header to the response.
     * 
     * @param cookie
     */
    void addCookie(Cookie cookie);

    /**
     * Writes the response produced by EsiGate to the client. This includes response status line, headers and HttpEntity
     * 
     * @param response
     * @throws IOException
     *             if an problem occurs while writing to the network connection
     */
    void sendResponse(HttpResponse response) throws IOException;

    /**
     * Stores an object that can be reused across successive http requests from the same user. Implementations can
     * decide to store the objects serialized in a cookie on the client side or server side with some session tracking
     * mechanism.
     * 
     * @param key
     * @param value
     */
    void setSessionAttribute(String key, Serializable value);

    /**
     * Retrieves an Object previously stored with method @see #setSessionAttribute(String, Serializable) or
     * <code>null</code>.
     * 
     * @param key
     * @return the previously stored object or <code>null</code>
     */
    Serializable getSessionAttribute(String key);

    /**
     * Returns the <code>IncomingRequest</code> representing the request received by the container. Subsequent calls to
     * this method should return the same instance.
     * 
     * @return the <code>IncomingRequest</code>
     */
    IncomingRequest getHttpRequest();

}
