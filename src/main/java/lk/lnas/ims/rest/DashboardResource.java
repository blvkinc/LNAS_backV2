package lk.lnas.ims.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lk.lnas.ims.service.DashboardService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardResource {
    private final DashboardService dashboardService;

    @GetMapping("/sales/total-sales")
    public ResponseEntity<BigDecimal> getTotalSales() {
        BigDecimal totalSales = dashboardService.getTotalSales();
        return ResponseEntity.ok(totalSales);
    }

    @GetMapping("/sales/total-production")
    public ResponseEntity<BigDecimal> getTotalProduction() {
        BigDecimal totalProduction = dashboardService.getTotalProduction();
        return ResponseEntity.ok(totalProduction);
    }

    @GetMapping("/sales/total-count")
    public ResponseEntity<BigDecimal> getTotalCount() {
        BigDecimal totalCount = dashboardService.getTotalCount();
        return ResponseEntity.ok(totalCount);
    }

    @GetMapping("/Production/total-farm")
    public ResponseEntity<BigDecimal> getTotalFarms() {
        BigDecimal totalCount = dashboardService.getTotalFarms();
        return ResponseEntity.ok(totalCount);
    }

    @GetMapping("/sales/monthly-sales")
    public ResponseEntity<BigDecimal> getMonthlySales() {
        BigDecimal monthlySales = dashboardService.getMonthlySales();
        return ResponseEntity.ok(monthlySales);
    }

    @GetMapping("/sales/monthly-production")
    public ResponseEntity<BigDecimal> getMonthlyProduction() {
        BigDecimal monthlyProduction = dashboardService.getMonthlyProduction();
        return ResponseEntity.ok(monthlyProduction);
    }

    @GetMapping("/plant/monthly-count")
    public ResponseEntity<BigDecimal> getMonthlyPlantCount() {
        BigDecimal monthlyPlantCount = dashboardService.getMonthlyPlantCount();
        return ResponseEntity.ok(monthlyPlantCount);
    }

    @GetMapping("/farms/active-count")
    public ResponseEntity<BigDecimal> getActiveFarmsCount() {
        BigDecimal activeFarmsCount = dashboardService.getActiveFarmsCount();
        return ResponseEntity.ok(activeFarmsCount);
    }

    @GetMapping("/sales/weekly-sales")
    public ResponseEntity<List<Object[]>> getWeeklySales() {
        List<Object[]> weeklySales = dashboardService.getWeeklySales();
        return ResponseEntity.ok(weeklySales);
    }

    @GetMapping("/purchase/weekly-purchase")
    public ResponseEntity<List<Object[]>> getWeeklyPurchase() {
        List<Object[]> weeklyPurchase = dashboardService.getWeeklyPurchase();
        return ResponseEntity.ok(weeklyPurchase);
    }

    @GetMapping("/monthly-production-by-farm")
    public ResponseEntity<List<Object[]>> getMonthlyProductionByFarm() {
        List<Object[]> MonthlyProductionByFarm = dashboardService.getMonthlyProductionByFarm();
        return ResponseEntity.ok(MonthlyProductionByFarm);
    }

    @GetMapping("/production/monthly-production-by-week")
    public ResponseEntity<List<Object[]>> getMonthlyProductionByWeek() {
        List<Object[]> MonthlyProductionByWeek = dashboardService.getMonthlyProductionByWeek();
        return ResponseEntity.ok(MonthlyProductionByWeek);
    }

    @GetMapping("/production/monthly-production-by-Availability")
    public ResponseEntity<List<Object[]>> getMonthlyProductionByAvailability() {
        List<Object[]> MonthlyProductionByAvailability = dashboardService.getMonthlyProductionByAvailability();
        return ResponseEntity.ok(MonthlyProductionByAvailability);
    }

}
