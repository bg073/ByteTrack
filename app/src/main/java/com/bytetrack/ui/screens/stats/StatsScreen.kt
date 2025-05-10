package com.bytetrack.ui.screens.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle
import com.bytetrack.R
import com.bytetrack.ui.viewmodels.StatsViewModel

@Composable
fun StatsScreen(
    modifier: Modifier = Modifier,
    viewModel: StatsViewModel = viewModel()
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    
    val tabs = listOf("Day", "Week", "Month")
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.nav_stats),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title) }
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        when (selectedTabIndex) {
            0 -> DailyStatsChart()
            1 -> WeeklyStatsChart()
            2 -> MonthlyStatsChart()
        }
    }
}

@Composable
fun DailyStatsChart() {
    // Sample data for daily calories
    val barData = listOf(
        BarData(
            point = Point(0f, 350f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Breakfast"
        ),
        BarData(
            point = Point(1f, 450f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Lunch"
        ),
        BarData(
            point = Point(2f, 580f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Dinner"
        ),
        BarData(
            point = Point(3f, 250f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Snacks"
        )
    )
    
    val maxCalories = 600f
    
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(barData.size - 1)
        .labelData { i -> barData[i].label ?: "" }
        .labelAndAxisLinePadding(15.dp)
        .build()
    
    val yAxisData = AxisData.Builder()
        .steps(5)
        .labelData { i -> (i * (maxCalories / 5)).toInt().toString() }
        .labelAndAxisLinePadding(15.dp)
        .build()
    
    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(barWidth = 35.dp)
    )
    
    BarChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        barChartData = barChartData
    )
}

@Composable
fun WeeklyStatsChart() {
    // Sample data for weekly calories
    val barData = listOf(
        BarData(
            point = Point(0f, 1800f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Mon"
        ),
        BarData(
            point = Point(1f, 2100f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Tue"
        ),
        BarData(
            point = Point(2f, 1950f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Wed"
        ),
        BarData(
            point = Point(3f, 2050f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Thu"
        ),
        BarData(
            point = Point(4f, 2200f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Fri"
        ),
        BarData(
            point = Point(5f, 2300f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Sat"
        ),
        BarData(
            point = Point(6f, 1900f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Sun"
        )
    )
    
    val maxCalories = 2500f
    
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(barData.size - 1)
        .labelData { i -> barData[i].label ?: "" }
        .labelAndAxisLinePadding(15.dp)
        .build()
    
    val yAxisData = AxisData.Builder()
        .steps(5)
        .labelData { i -> (i * (maxCalories / 5)).toInt().toString() }
        .labelAndAxisLinePadding(20.dp)
        .build()
    
    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(barWidth = 25.dp)
    )
    
    BarChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        barChartData = barChartData
    )
}

@Composable
fun MonthlyStatsChart() {
    // Sample data for monthly calories (weekly averages)
    val barData = listOf(
        BarData(
            point = Point(0f, 2050f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Week 1"
        ),
        BarData(
            point = Point(1f, 1950f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Week 2"
        ),
        BarData(
            point = Point(2f, 2100f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Week 3"
        ),
        BarData(
            point = Point(3f, 2000f),
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            label = "Week 4"
        )
    )
    
    val maxCalories = 2500f
    
    val xAxisData = AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(barData.size - 1)
        .labelData { i -> barData[i].label ?: "" }
        .labelAndAxisLinePadding(15.dp)
        .build()
    
    val yAxisData = AxisData.Builder()
        .steps(5)
        .labelData { i -> (i * (maxCalories / 5)).toInt().toString() }
        .labelAndAxisLinePadding(20.dp)
        .build()
    
    val barChartData = BarChartData(
        chartData = barData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        barStyle = BarStyle(barWidth = 35.dp)
    )
    
    BarChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        barChartData = barChartData
    )
} 