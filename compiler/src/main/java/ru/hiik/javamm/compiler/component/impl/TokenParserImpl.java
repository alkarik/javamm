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

package ru.hiik.javamm.compiler.component.impl;

import java.util.List;
import ru.hiik.javamm.compiler.component.TokenParser;
import ru.hiik.javamm.compiler.model.TokenParserResult;

/**
 * @author alkarik
 * @link http://alkarik
 */
public class TokenParserImpl implements TokenParser {
    @Override
    public TokenParserResult parseLine(final String line, final boolean multilineCommentStarted) {
        final List<String> tokens=line.isEmpty() ? List.of() : List.of(line.trim().split(" "));
        return new TokenParserResult(tokens,false);
    }
}
