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

package com.nigelsmall.geoff.validator;

import com.nigelsmall.geoff.reader.GeoffReaderException;
import com.nigelsmall.geoff.reader.GeoffReader;
import com.nigelsmall.geoff.Subgraph;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GeoffValidator {

    public static void validate(Reader reader) throws IOException, GeoffReaderException {
        int i = 0;
        GeoffReader geoffReader = new GeoffReader(reader);
        while (geoffReader.hasMore()) {
            Subgraph subgraph = geoffReader.readSubgraph();
            System.out.println("----------------------------------------");
            System.out.println("Subgraph: " + Integer.toString(i));
            System.out.println("----------------------------------------");
            System.out.println(subgraph);
            i += 1;
        }
    }

    public static void main(String... args) throws IOException, GeoffReaderException {
        for (String arg: args) {
            System.out.println("========================================");
            System.out.println("Document: " + arg);
            System.out.println("========================================");
            validate(new FileReader(arg));
        }
        System.out.println("----------------------------------------");
    }

}
