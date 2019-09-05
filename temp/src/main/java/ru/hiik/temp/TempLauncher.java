/*
 * Copyright (c) 2019.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ru.hiik.temp;

import static java.util.Objects.requireNonNull;

/**
 * @author alkarik
 * @link http://alkarik
 */
public class TempLauncher {
    public static void main(String[] args) {
        final SourceLine sourceLine = new SourceLine("file.txt",5,"hello");
        System.out.println(sourceLine.getFileName());
        System.out.println(sourceLine.getNumber());

        for (int i = 0; i < 10; i++) {
            System.out.println();

        }

        for (int i = 0; i < args.length; i++) {
            requireNonNull(args);

        }

    }
}
