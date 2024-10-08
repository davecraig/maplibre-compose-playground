/*
 * This file is part of ramani-maps.
 *
 * Copyright (c) 2023 Roman Bapst & Jonas Vautherin.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.maplibre.compose.ramani

import android.graphics.PointF
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import org.maplibre.android.geometry.LatLng

@Composable
fun PixelToCoordMapper(points: List<PointF>, onChange: (List<LatLng>) -> Unit) {
  val mapApplier = currentComposer.applier as MapApplier
  val projection = mapApplier.map.projection

  onChange(points.map { projection.fromScreenLocation(it) })
}
