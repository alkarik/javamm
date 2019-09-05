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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import ru.hiik.javamm.code.fragment.SourceCode;
import ru.hiik.javamm.code.fragment.SourceLine;
import ru.hiik.javamm.compiler.component.SourceLineReader;
import ru.hiik.javamm.compiler.component.TokenParser;
import ru.hiik.javamm.compiler.model.TokenParserResult;

/**
 * @author alkarik
 * @link http://alkarik
 */
public class SourceLineReaderImpl implements SourceLineReader {

    private final TokenParser tokenParser;

    public SourceLineReaderImpl(final TokenParser tokenParser) {
        this.tokenParser = requireNonNull(tokenParser);
    }

    @Override
    public List<SourceLine> read(final SourceCode sourceCode) {
        final List<SourceLine> list = new ArrayList<>();
        final String moduleName = sourceCode.getModuleName();
        int number = 1;
        boolean multilineCommentStarted = false;
        for (final String line : sourceCode.getLines()) {
            final TokenParserResult tokenParserResult = tokenParser.parseLine(line, multilineCommentStarted);
            multilineCommentStarted = tokenParserResult.isMultilineCommentStarted();
            if (tokenParserResult.isNotEmpty()) {
                list.add(new SourceLine(moduleName, number, tokenParserResult.getTokens()));
            }
            number++;
        }
        return Collections.unmodifiableList(list);
    }
}
