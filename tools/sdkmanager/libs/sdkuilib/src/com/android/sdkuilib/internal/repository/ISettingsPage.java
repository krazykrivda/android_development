/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.sdkuilib.internal.repository;

import java.net.URL;
import java.util.Properties;

/**
 * Interface that a settings page must implement.
 */
public interface ISettingsPage {

    /** Java system setting picked up by {@link URL} for http proxy port */
    public static final String JAVA_HTTP_PROXY_PORT = "http.proxyPort";        //$NON-NLS-1$
    /** Java system setting picked up by {@link URL} for http proxy host */
    public static final String JAVA_HTTP_PROXY_HOST = "http.proxyHost";        //$NON-NLS-1$

    /** Loads settings from the given {@link Properties} container and update the page UI. */
    public abstract void loadSettings(Properties in_settings);

    /** Called by the application to retrieve settings from the UI and store them in
     * the given {@link Properties} container. */
    public abstract void retrieveSettings(Properties out_settings);

    /**
     * Called by the application to give a callback that the page should invoke when
     * settings have changed.
     */
    public abstract void setOnSettingsChanged(SettingsChangedCallback settingsChangedCallback);

    /**
     * Callback used to notify the application that settings have changed and need to be
     * applied.
     */
    public interface SettingsChangedCallback {
        /**
         * Invoked by the settings page when settings have changed and need to be
         * applied. The application will call {@link ISettingsPage#retrieveSettings(Properties)}
         * and apply the new settings.
         */
        public abstract void onSettingsChanged(ISettingsPage page);
    }
}