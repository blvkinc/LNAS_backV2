package lk.lnas.ims.rest;

import lk.lnas.ims.model.report.MonthlyProductionByFarm;
import lk.lnas.ims.model.report.OrderSummary;
import lk.lnas.ims.model.report.ProductionQuantity;
import lk.lnas.ims.model.report.ProductionSummary;
import lk.lnas.ims.security.util.Roles;
import lk.lnas.ims.service.OrderService;
import lk.lnas.ims.service.ProductionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/reports", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportResource {

    private final ProductionService productionService;
    private final OrderService salesService;

    @GetMapping("/production/weekly-production")
    @PreAuthorize("hasAuthority('" + Roles.ADMIN + "')")
    public ResponseEntity<List<ProductionQuantity>> getWeeklyProduction() {
        return ok(productionService.getPastFourWeeksProductionQuantities());
    }

    @GetMapping("/production/monthly-production")
    @PreAuthorize("hasAuthority('" + Roles.ADMIN + "')")
    public ResponseEntity<List<ProductionQuantity>> getMonthlyProduction() {
        return ok(productionService.getPastSixMonthsProductionQuantities());
    }

    @GetMapping("/production/by-status")
    @PreAuthorize("hasAuthority('" + Roles.ADMIN + "')")
    public ResponseEntity<List<ProductionSummary>> getProductionByStatus() {
        return ok(productionService.getProductionSummaryByStatus());
    }

    @GetMapping("/production/by-farm")
    @PreAuthorize("hasAuthority('" + Roles.ADMIN + "')")
    public ResponseEntity<List<MonthlyProductionByFarm>> getProductionByFarm() {
        return ok(productionService.getMonthlyProductionByFarm());
    }

    @GetMapping("/sales/weekly-sales")
    @PreAuthorize("hasAuthority('" + Roles.ADMIN + "')")
    public ResponseEntity<List<OrderSummary>> getWeeklySales() {
        return ok(salesService.getWeeklyOrderSummaries());
    }

    @GetMapping("/sales/monthly-sales")
    @PreAuthorize("hasAuthority('" + Roles.ADMIN + "')")
    public ResponseEntity<List<OrderSummary>> getMonthlySales() {
        return ok(salesService.getMonthlyOrderSummaries());
    }
}
