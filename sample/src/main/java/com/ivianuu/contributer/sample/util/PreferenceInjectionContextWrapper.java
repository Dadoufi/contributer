/*
 * Copyright 2017 Manuel Wrage
 *
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
 */

package com.ivianuu.contributer.sample.util;


import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.preference.Preference;

import com.ivianuu.contributer.supportpreference.HasSupportPreferenceInjector;

import dagger.android.AndroidInjector;

/**
 * Wraps a {@link Context} and is a {@link com.ivianuu.contributer.supportpreference.HasSupportPreferenceInjector}
 * to make it possible to inject stuff from a {@link android.support.v7.preference.PreferenceFragmentCompat}
 * into {@link Preference}'s
 */
public class PreferenceInjectionContextWrapper extends ContextWrapper implements HasSupportPreferenceInjector {

    private final HasSupportPreferenceInjector supportPreferenceInjector;

    public PreferenceInjectionContextWrapper(Context context,
                                             HasSupportPreferenceInjector supportPreferenceInjector) {
        super(context);
        this.supportPreferenceInjector = supportPreferenceInjector;
    }

    @Override
    public AndroidInjector<Preference> supportPreferenceInjector() {
        // delegate to the "real" injector
        return supportPreferenceInjector.supportPreferenceInjector();
    }
}