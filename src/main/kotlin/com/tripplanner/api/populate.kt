package com.tripplanner.api

import com.tripplanner.api.constant.FuelType
import com.tripplanner.api.entity.Engine
import com.tripplanner.api.entity.Make
import com.tripplanner.api.entity.Model
import com.tripplanner.api.entity.Version

fun populate(): List<Make> = listOf(
			Make("Hyundai", listOf(
					Model("Grand i10", listOf(
							Version(2017, "Lounge", 47, Engine("1.0 l 66", FuelType.GASOLINE)),
							Version(2017, "Lounge+", 47, Engine("1.0 l 66", FuelType.GASOLINE)),
							Version(2017, "Lounge BVA", 58, Engine("1.0 l 66", FuelType.GASOLINE))
					)),
					Model("i20", listOf(
							Version(2018, "Attractive", 48, Engine("1.25 MPI 84", FuelType.GASOLINE)),
							Version(2018, "BVA Attractive", 53, Engine("1.4 MPI 100", FuelType.GASOLINE)),
							Version(2018, "Inventive", 48, Engine("1.25 MPI 84", FuelType.GASOLINE)),
							Version(2018, "Attractive", 41, Engine("1.4 CRDI 90", FuelType.GASOLINE)),
							Version(2018, "Inventive", 41, Engine("1.4 CRDI 90", FuelType.GASOLINE)),
							Version(2018, "Seductive", 41, Engine("1.4 CRDI 90", FuelType.GASOLINE)),
							Version(2018, "Seductive Bi-ton", 41, Engine("1.4 CRDI 90", FuelType.GASOLINE))
					)),
					Model("Accent", listOf(
							Version(2019, "Attractive", 46, Engine("1.6 CRDi 128", FuelType.DIESEL)),
							Version(2019, "BVA Attractive", 54, Engine("1.6 CRDi 128", FuelType.DIESEL)),
							Version(2019, "Inventive", 46, Engine("1.6 CRDi 128", FuelType.DIESEL)),
							Version(2019, "BVA Inventive", 54, Engine("1.6 CRDi 128", FuelType.DIESEL))
					)),
					Model("i30", listOf(
							Version(2017, "Attractive", 39, Engine("1.6 CRDi 136", FuelType.DIESEL)),
							Version(2017, "Inventive", 39, Engine("1.6 CRDi 136", FuelType.DIESEL)),
							Version(2017, "Seductive", 39, Engine("1.6 CRDi 136", FuelType.DIESEL)),
							Version(2017, "Inventive", 41, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2017, "Seductive", 41, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL))
					)),
					Model("Elantra", listOf(
							Version(2017, "Inventive", 45, Engine("1.6 CRDi 136", FuelType.DIESEL)),
							Version(2017, "Inventive", 41, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2017, "Seductive", 45, Engine("1.6 CRDi 136", FuelType.DIESEL)),
							Version(2017, "Seductive", 41, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2017, "Impressive", 41, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL))
					)),
					Model("Creta", listOf(
							Version(2015, "Arena", 49, Engine("1.4 CRDi 90", FuelType.DIESEL)),
							Version(2015, "Odyssée", 49, Engine("1.4 CRDi 90", FuelType.DIESEL)),
							Version(2015, "Appolon", 52, Engine("1.6 CRDi 128", FuelType.DIESEL)),
							Version(2015, "BVA Apollon", 52, Engine("1.6 CRDi 128", FuelType.DIESEL))
					)),
					Model("Kona", listOf(
							Version(2018, "Style", 54, Engine("1.0 T-GDI", FuelType.GASOLINE)),
							Version(2018, "BVA Style", 54, Engine("1.0 T-GDI", FuelType.GASOLINE))
					)),
					Model("IONIQ", listOf(
							Version(2018, "Aera", 39, Engine("1.6 GDI 141 DCT", FuelType.HYBRIDE)),
							Version(2018, "Energia", 39, Engine("1.6 GDI 141 DCT", FuelType.HYBRIDE)),
							Version(2018, "Volta", 39, Engine("1.6 GDI 141 DCT", FuelType.HYBRIDE))
					)),
					Model("Tucson", listOf(
							Version(2019, "Prestige", 48, Engine("1.6 CRDi 115", FuelType.DIESEL)),
							Version(2019, "Prestige", 49, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2019, "Premium", 49, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2019, "Luxe", 49, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2019, "4x4 Luxe", 65, Engine("2.0 CRDi 185 7DCT", FuelType.DIESEL)),

							Version(2016, "Intuitive", 48, Engine("1.6 CRDi 115", FuelType.DIESEL)),
							Version(2016, "Emotive", 48, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL)),
							Version(2016, "Sensitive", 48, Engine("1.6 CRDi 136 7DCT", FuelType.DIESEL))

					)),
					Model("i40", listOf(
							Version(2016, "Confort", 46, Engine("1.7 CRDi", FuelType.DIESEL)),
							Version(2016, "Confort", 49, Engine("1.7 CRDi 7DCT", FuelType.DIESEL)),
							Version(2016, "Prestige", 49, Engine("1.7 CRDi 7DCT", FuelType.DIESEL)),
							Version(2016, "Luxe+", 49, Engine("1.7 CRDi 7DCT", FuelType.DIESEL))
					)),
					Model("Santa Fe", listOf(
							Version(2018, "Elegance", 60, Engine("2.2 CRDi 200", FuelType.DIESEL)),
							Version(2018, "Prestige", 60, Engine("2.2 CRDi 200", FuelType.DIESEL)),
							Version(2018, "Premium", 60, Engine("2.2 CRDi 200", FuelType.DIESEL)),
							Version(2018, "Luxe", 60, Engine("2.2 CRDi 200", FuelType.DIESEL)),
							Version(2018, "Luxe 4x4", 63, Engine("2.2 CRDi 200", FuelType.DIESEL))
					))
			))
	)