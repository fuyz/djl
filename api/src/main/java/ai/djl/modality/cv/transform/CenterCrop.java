/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package ai.djl.modality.cv.transform;

import ai.djl.modality.cv.util.NDImageUtils;
import ai.djl.ndarray.NDArray;
import ai.djl.translate.Transform;

public class CenterCrop implements Transform {

    private int width;
    private int height;

    public CenterCrop() {
        width = -1;
        height = -1;
    }

    public CenterCrop(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public NDArray transform(NDArray array) {
        if (width < 0) {
            return NDImageUtils.centerCrop(array);
        }
        return NDImageUtils.centerCrop(array, width, height);
    }
}