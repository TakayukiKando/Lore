/*
 * [Apache License 2.0]
 * Copyright 2014 T.Kando and Inuyama-ya sanpu.
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
package org.xgmtk.lore.utils;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * TODO write JavaDoc comment.
 * 
 * @author kando
 *
 */
public final class SystemErrorHandler extends Handler {
	@Override
	public void publish(LogRecord record) {
		System.err.println(record.getMessage());
	}

	@Override
	public void flush() {
		System.err.flush();
	}

	@Override
	public void close() throws SecurityException {
		//System.err.close();
	}
}