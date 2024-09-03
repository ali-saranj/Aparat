/*
 * Copyright (C) 2022 The Android Open Source Project
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

package ali.saranj.aparat.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ali.saranj.aparat.ui.dataitemtype.DataItemTypeScreen
import ali.saranj.aparat.ui.screen.detail.DetailScreen
import ali.saranj.aparat.ui.screen.main.MainScreen
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavigationItem.Main.route) {
        composable(NavigationItem.Main.route) {
            MainScreen(
                modifier = Modifier.padding(16.dp)
            )
        }
        composable(NavigationItem.DetailVideo.route){
            DetailScreen()
        }
        // TODO: Add more destinations
    }
}
