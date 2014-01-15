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

package com.nigelsmall.reader.test;

import com.nigelsmall.geoff.reader.GeoffReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

public class DocumentTest {

    final private Logger logger = LoggerFactory.getLogger(DocumentTest.class);

    final GeoffReader geoffReader;

    public DocumentTest(Reader reader) throws IOException {
        this.geoffReader = new GeoffReader(reader);
    }

    public void run() throws IOException {
        while (this.geoffReader.hasMore()) {
            SubgraphTest test = new SubgraphTest(this.geoffReader.readSubgraph());
            test.run();
        }
    }

}
