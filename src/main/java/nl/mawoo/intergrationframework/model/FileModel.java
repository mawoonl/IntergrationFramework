/**
 * Copyright 2017 Mawoo Nederland
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
package nl.mawoo.intergrationframework.model;

import java.nio.file.attribute.FileTime;

public class FileModel implements MainDataModel {
    private String _source;
    private String fileName;
    private boolean isDirectory;
    private FileTime lastModified;
    private FileTime creationDate;

    public FileModel(String source, String fileName, boolean isDirectory, FileTime lastModified, FileTime creationDate) {
        this._source = source;
        this.fileName = fileName;
        this.isDirectory = isDirectory;
        this.lastModified = lastModified;
        this.creationDate = creationDate;
    }

    public String getSource() {
        return _source;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public FileTime getLastModified() {
        return lastModified;
    }

    public FileTime getCreationDate() {
        return creationDate;
    }
}
