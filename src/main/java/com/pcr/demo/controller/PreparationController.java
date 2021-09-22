package com.pcr.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pcr.demo.entity.Dna;
import com.pcr.demo.entity.Primer;
import com.pcr.demo.repository.PrimerRepository;

//the whole PCR process:
//	preparation
//  1.create a sequence of dna. Enter the length of dna you want to get
//  2.search a primer whose sequence coincides with part of the dna you created.</p>
//  3.now the system brings polymerase enzyme & buffer
//	pcr
//	1.denaturation 
//	2.annealing
//	3.extension
@RestController
public class PreparationController {

	private static final Logger logger = LoggerFactory.getLogger(PreparationController.class);

	private static String getDnaSequence_url = "http://localhost:8088/dna/v1/dnaSequence/";

	@Autowired
	PrimerRepository primerRepository;

	// ajax call from front.html
	@RequestMapping(method = RequestMethod.GET, path = "/prep1")
	public Dna getDnaSequence(@RequestParam final int dnaLength) {
		logger.info("prep1");
		// get dna sequence by its length through restTemplate
		// from consumeRestService project
		RestTemplate restTemplate = new RestTemplate(); // without this, RestTemplate null error occurs
		Dna dnaSequence = restTemplate.getForObject(getDnaSequence_url + dnaLength, Dna.class);

		return dnaSequence;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/primerSearch")
	public HashMap<String, List<Primer>> getPrimer(@RequestParam final String primerSequence, String c_primerSequence) {
		logger.info("PreparationController>getPrimer primerSequence is : ", primerSequence);
		logger.info("PreparationController>getPrimer c_primerSequence is : ", c_primerSequence);

		Primer primer1 = new Primer(1L, "SAMPLE1", "5-AAA-3", new Date(), "bejamin");
		primerRepository.save(primer1);
		Primer primer2 = new Primer(2L, "SAMPLE2", "5-AAC-3", new Date(), "bejamin");
		primerRepository.save(primer2);
		Primer primer3 = new Primer(3L, "SAMPLE3", "5-AAG-3", new Date(), "bejamin");
		primerRepository.save(primer3);
		Primer primer4 = new Primer(4L, "SAMPLE4", "5-AAT-3", new Date(), "bejamin");
		primerRepository.save(primer4);
		Primer primer5 = new Primer(5L, "SAMPLE5", "5-ACA-3", new Date(), "bejamin");
		primerRepository.save(primer5);
		Primer primer6 = new Primer(6L, "SAMPLE6", "5-ACC-3", new Date(), "bejamin");
		primerRepository.save(primer6);
		Primer primer7 = new Primer(7L, "SAMPLE7", "5-ACG-3", new Date(), "bejamin");
		primerRepository.save(primer7);

		Primer primer64 = new Primer(64L, "SAMPLE64", "5-ACT-3", new Date(), "bejamin");
		primerRepository.save(primer64);
		Primer primer65 = new Primer(65L, "SAMPLE65", "5-AGA-3", new Date(), "bejamin");
		primerRepository.save(primer65);
		Primer primer66 = new Primer(66L, "SAMPLE66", "5-AGC-3", new Date(), "bejamin");
		primerRepository.save(primer66);
		Primer primer67 = new Primer(67L, "SAMPLE67", "5-AGG-3", new Date(), "bejamin");
		primerRepository.save(primer67);
		Primer primer68 = new Primer(68L, "SAMPLE68", "5-AGT-3", new Date(), "bejamin");
		primerRepository.save(primer68);

		Primer primer12 = new Primer(13L, "SAMPLE12", "5-ATA-3", new Date(), "bejamin");
		primerRepository.save(primer12);
		Primer primer13 = new Primer(14L, "SAMPLE13", "5-ATC-3", new Date(), "bejamin");
		primerRepository.save(primer13);
		Primer primer14 = new Primer(15L, "SAMPLE14", "5-ATG-3", new Date(), "bejamin");
		primerRepository.save(primer14);
		Primer primer15 = new Primer(16L, "SAMPLE15", "5-ATT-3", new Date(), "bejamin");
		primerRepository.save(primer15);

		Primer primer16 = new Primer(17L, "SAMPLE16", "5-CAA-3", new Date(), "bejamin");
		primerRepository.save(primer16);
		Primer primer17 = new Primer(18L, "SAMPLE17", "5-CAC-3", new Date(), "bejamin");
		primerRepository.save(primer17);
		Primer primer18 = new Primer(19L, "SAMPLE18", "5-CAG-3", new Date(), "bejamin");
		primerRepository.save(primer18);
		Primer primer19 = new Primer(20L, "SAMPLE19", "5-CAT-3", new Date(), "bejamin");
		primerRepository.save(primer19);
		Primer primer20 = new Primer(21L, "SAMPLE20", "5-CCA-3", new Date(), "bejamin");
		primerRepository.save(primer20);
		Primer primer21 = new Primer(22L, "SAMPLE21", "5-CCC-3", new Date(), "bejamin");
		primerRepository.save(primer21);
		Primer primer22 = new Primer(23L, "SAMPLE22", "5-CCG-3", new Date(), "bejamin");
		primerRepository.save(primer22);
		Primer primer23 = new Primer(24L, "SAMPLE23", "5-CCT-3", new Date(), "bejamin");
		primerRepository.save(primer23);
		Primer primer24 = new Primer(25L, "SAMPLE24", "5-CGA-3", new Date(), "bejamin");
		primerRepository.save(primer24);
		Primer primer25 = new Primer(26L, "SAMPLE25", "5-CGC-3", new Date(), "bejamin");
		primerRepository.save(primer25);
		Primer primer26 = new Primer(27L, "SAMPLE26", "5-CGG-3", new Date(), "bejamin");
		primerRepository.save(primer26);
		Primer primer27 = new Primer(28L, "SAMPLE27", "5-CGT-3", new Date(), "bejamin");
		primerRepository.save(primer27);
		Primer primer28 = new Primer(29L, "SAMPLE28", "5-CTA-3", new Date(), "bejamin");
		primerRepository.save(primer28);
		Primer primer29 = new Primer(30L, "SAMPLE29", "5-CTC-3", new Date(), "bejamin");
		primerRepository.save(primer29);
		Primer primer30 = new Primer(31L, "SAMPLE30", "5-CTG-3", new Date(), "bejamin");
		primerRepository.save(primer30);
		Primer primer31 = new Primer(32L, "SAMPLE31", "5-CTT-3", new Date(), "bejamin");
		primerRepository.save(primer31);

		Primer primer32 = new Primer(33L, "SAMPLE31", "5-GAA-3", new Date(), "bejamin");
		primerRepository.save(primer32);
		Primer primer33 = new Primer(34L, "SAMPLE32", "5-GAC-3", new Date(), "bejamin");
		primerRepository.save(primer33);
		Primer primer34 = new Primer(35L, "SAMPLE33", "5-GAG-3", new Date(), "bejamin");
		primerRepository.save(primer34);
		Primer primer35 = new Primer(36L, "SAMPLE34", "5-GAT-3", new Date(), "bejamin");
		primerRepository.save(primer35);
		Primer primer36 = new Primer(37L, "SAMPLE35", "5-GCA-3", new Date(), "bejamin");
		primerRepository.save(primer36);
		Primer primer37 = new Primer(38L, "SAMPLE36", "5-GCC-3", new Date(), "bejamin");
		primerRepository.save(primer37);
		Primer primer38 = new Primer(39L, "SAMPLE37", "5-GCG-3", new Date(), "bejamin");
		primerRepository.save(primer38);
		Primer primer39 = new Primer(40L, "SAMPLE38", "5-GCT-3", new Date(), "bejamin");
		primerRepository.save(primer39);
		Primer primer40 = new Primer(41L, "SAMPLE39", "5-GGA-3", new Date(), "bejamin");
		primerRepository.save(primer40);
		Primer primer41 = new Primer(41L, "SAMPLE40", "5-GGC-3", new Date(), "bejamin");
		primerRepository.save(primer41);
		Primer primer42 = new Primer(42L, "SAMPLE42", "5-GGG-3", new Date(), "bejamin");
		primerRepository.save(primer42);
		Primer primer43 = new Primer(43L, "SAMPLE43", "5-GGT-3", new Date(), "bejamin");
		primerRepository.save(primer43);
		Primer primer61 = new Primer(61L, "SAMPLE61", "5-GTA-3", new Date(), "bejamin");
		primerRepository.save(primer61);
		Primer primer62 = new Primer(62L, "SAMPLE62", "5-GTC-3", new Date(), "bejamin");
		primerRepository.save(primer62);
		Primer primer63 = new Primer(63L, "SAMPLE63", "5-GTG-3", new Date(), "bejamin");
		primerRepository.save(primer63);
		Primer primer60 = new Primer(60L, "SAMPLE60", "5-GTT-3", new Date(), "bejamin");
		primerRepository.save(primer60);

		Primer primer44 = new Primer(44L, "SAMPLE44", "5-TAA-3", new Date(), "bejamin");
		primerRepository.save(primer44);
		Primer primer45 = new Primer(45L, "SAMPLE45", "5-TAC-3", new Date(), "bejamin");
		primerRepository.save(primer45);
		Primer primer46 = new Primer(46L, "SAMPLE46", "5-TAG-3", new Date(), "bejamin");
		primerRepository.save(primer46);
		Primer primer47 = new Primer(47L, "SAMPLE47", "5-TAT-3", new Date(), "bejamin");
		primerRepository.save(primer47);
		Primer primer48 = new Primer(48L, "SAMPLE48", "5-TCA-3", new Date(), "bejamin");
		primerRepository.save(primer48);
		Primer primer49 = new Primer(49L, "SAMPLE49", "5-TCC-3", new Date(), "bejamin");
		primerRepository.save(primer49);
		Primer primer50 = new Primer(50L, "SAMPLE50", "5-TCG-3", new Date(), "bejamin");
		primerRepository.save(primer50);
		Primer primer51 = new Primer(51L, "SAMPLE51", "5-TCT-3", new Date(), "bejamin");
		primerRepository.save(primer51);
		Primer primer52 = new Primer(52L, "SAMPLE52", "5-TGA-3", new Date(), "bejamin");
		primerRepository.save(primer52);
		Primer primer53 = new Primer(53L, "SAMPLE53", "5-TGC-3", new Date(), "bejamin");
		primerRepository.save(primer53);
		Primer primer54 = new Primer(54L, "SAMPLE54", "5-TGG-3", new Date(), "bejamin");
		primerRepository.save(primer54);
		Primer primer55 = new Primer(55L, "SAMPLE55", "5-TGT-3", new Date(), "bejamin");
		primerRepository.save(primer55);
		Primer primer56 = new Primer(56L, "SAMPLE56", "5-TTA-3", new Date(), "bejamin");
		primerRepository.save(primer56);
		Primer primer57 = new Primer(57L, "SAMPLE57", "5-TTC-3", new Date(), "bejamin");
		primerRepository.save(primer57);
		Primer primer58 = new Primer(58L, "SAMPLE58", "5-TTG-3", new Date(), "bejamin");
		primerRepository.save(primer58);
		Primer primer59 = new Primer(59L, "SAMPLE59", "5-TTT-3", new Date(), "bejamin");
		primerRepository.save(primer59);

		logger.info("primerRepository.findAll()");
		List<Primer> primerList = primerRepository.findAll();
		logger.info("primerList  : " + primerList);
		for (Primer pr : primerList) {
			System.out.println(pr);
		}

		// find the matching primer by id
		// Optional<Primer> userWithIdOne = primerRepository.findById(26L);
		// logger.info("primer is retrieved : " + userWithIdOne.get());

		HashMap<String, List<Primer>> hs = new HashMap();

		// find the matching primer by subSequence
		List<Primer> result = primerRepository.findBySubSequence(primerSequence);
		hs.put("result", result);
		logger.info("findBySubSequence result(primerSequence) : " + result);

		List<Primer> result_c = primerRepository.findBySubSequence(c_primerSequence);
		hs.put("result_c", result_c);
		logger.info("findBySubSequence result(c_primerSequence) : " + result_c);

		// store the primer sequence& dna sequence to redis, and retrieve those
		// informations
		// into users page.
		return hs;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/test")
	public String test(@RequestParam int dnaLength) {

		logger.info("test=== : ", dnaLength);

		return "testvvv";
	}

}
