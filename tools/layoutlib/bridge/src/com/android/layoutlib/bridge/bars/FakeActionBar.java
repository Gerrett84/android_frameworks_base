/*
 * Copyright (C) 2011 The Android Open Source Project
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

package com.android.layoutlib.bridge.bars;

import com.android.resources.Density;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FakeActionBar extends CustomBar {

    private TextView mTextView;

    public FakeActionBar(Context context, Density density, String label, String icon)
            throws XmlPullParserException {
        super(context, density, LinearLayout.HORIZONTAL, "/bars/action_bar.xml", "action_bar.xml");

        // Cannot access the inside items through id because no R.id values have been
        // created for them.
        // We do know the order though.
        loadIconById(android.R.id.home, icon);
        mTextView = setText(1, label);

        setStyle("actionBarStyle");
    }

    @Override
    protected TextView getStyleableTextView() {
        return mTextView;
    }
}
