package org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept;

import org.openmrs.Concept;
import org.openmrs.api.ConceptNameType;
import org.openmrs.module.metadatadeploy.MetadataUtils;
import org.openmrs.module.metadatadeploy.builder.ConceptBuilder;
import org.openmrs.module.metadatadeploy.builder.ConceptNumericBuilder;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.openmrs.module.pihmalawi.metadata.ChronicCareMetadata;
import org.openmrs.module.pihmalawi.metadata.PdcMetadata;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.VersionedPihConceptBundle;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Requires({CoreConceptMetadataBundle.class})
public class PdcConcepts extends VersionedPihConceptBundle {

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    protected void installNewVersion() throws Exception {
        Concept yes = MetadataUtils.existing(Concept.class, CommonConcepts.Concepts.YES);
        Concept no = MetadataUtils.existing(Concept.class, CommonConcepts.Concepts.NO);
        Concept unknown = MetadataUtils.existing(Concept.class, CommonConcepts.Concepts.UNKNOWN);

        // Perinatal Infection
        Concept perinatalInfection = install(new ConceptBuilder("5c1f2ade-4224-46c3-99f5-7236aab13f13")
                .datatype(coded)
                .conceptClass(question)
                .name("50474960-c5b2-48a9-8bb7-ec4ff193d52d", "Perinatal infection",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .answers(yes,no,unknown)
                .build());

        // Gestational age
        Concept gestationalAge  = install(new ConceptNumericBuilder("31bf4e2a-0574-47f3-9c68-9d530ebff898")
                .datatype(numeric)
                .conceptClass(question)
                .units("weeks")
                .name("06c508fa-d080-45b1-984b-412067e01800", "Gestational Age", Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .description("4f3e0805-3059-4226-abcd-6100cddd9543", "Gestational age in weeks", Locale.ENGLISH)
                .build());

        // Cup-feeding
        Concept cupFeeding = install(new ConceptBuilder("4f3e0805-3059-4226-abcd-6100cddd9543")
                .datatype(coded)
                .conceptClass(question)
                .name("5cecddc6-edbd-48f8-bdd9-51d62a074382", "Cup-feeding",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .answers(yes,no)
                .build());

        //Premature Birth
        Concept prematureBirth = install(new ConceptBuilder(PdcMetadata.PREMATURE_BIRTH)
                .datatype(coded)
                .conceptClass(finding)
                .name("730c4b07-8060-4690-bb23-d5674d39ce5d", "Premature Birth",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        //Asphyxia
       /* install(new ConceptBuilder("730c4b07-8060-4690-bb23-d5674d39ce5d")
                .datatype(coded)
                .conceptClass(diagnosis)
                .name(PdcMetadata.PREMATURE_BIRTH, "Premature Birth",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        */


        //Hydrocephalus
        Concept hydrocephalus = install(new ConceptBuilder(PdcMetadata.HYDROCEPHALUS)
                .datatype(coded)
                .conceptClass(diagnosis)
                .name("59cee21f-12c3-4f31-aeca-18d4fc75107f", "Hydrocephalus",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        //Downs Syndrome
        Concept downsSyndrome = install(new ConceptBuilder(PdcMetadata.DOWNS_SYNDROME)
                .datatype(coded)
                .conceptClass(diagnosis)
                .name("cd46206a-a25e-4131-ad99-9aa9c9c2107a", "Downs Syndrome (Suspected or Confirmed)",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        //Cleft Lip or Palate
        Concept cleftLipOrPalate = install(new ConceptBuilder(PdcMetadata.CLEFT_LIP)
                .datatype(coded)
                .conceptClass(diagnosis)
                .name("87a58bee-850e-4fda-b625-3daa674e78fd", "Cleft Lip or Palate",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        //Other Developmental Delay
        Concept otherDevelopmentDelay =install(new ConceptBuilder(PdcMetadata.OTHER_DEVELOPMENTAL_DELAY)
                .datatype(coded)
                .conceptClass(diagnosis)
                .name("208cb938-9c1c-4916-8f03-b957956e9869", "Other Developmental Delay, Suspected Neuromuscular " +
                                "Disease, and Suspected Genetic Syndromes",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        //Severe malnutrition requiring club foot, hospitalization (infant < 12 months)
        Concept severeMalnutrition = install(new ConceptBuilder(PdcMetadata.SEVERE_MALNUTRITION)
                .datatype(coded)
                .conceptClass(diagnosis)
                .name("0428535f-3efc-4c38-a5b3-179f43ac29b1", "Severe malnutrition requiring club foot, " +
                                "hospitalization (infant < 12 months)",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .build());

        //Age of guardian
        Concept ageOfGuardian = install(new ConceptNumericBuilder(PdcMetadata.AGE_OF_GUARDIAN)
                .datatype(numeric)
                .conceptClass(question)
                .units("Years")
                .precise(false)
                .name("ea645ac7-e75f-4a21-9058-9124267838d1", "Age of guardian", Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .description("4ba1b6dd-15e1-4863-b83b-05360f8ee569", "Guardian age in years", Locale.ENGLISH)
                .build());

        Concept lowBirthWeight = MetadataUtils.existing(Concept.class, PdcMetadata.LOW_BIRTH_WEIGHT);
        Concept centralNervousSystem = MetadataUtils.existing(Concept.class,PdcMetadata.CENTRAL_NERVOUS_SYSTEM);
        // Reasons for referral
        Concept reasonsForReferral = install(new ConceptBuilder(PdcMetadata.REASON_FOR_REFERRAL)
                .datatype(coded)
                .conceptClass(question)
                .name("b71eb2d2-7326-4646-97e0-a60265ce101f", "PDC Reasons for referral",
                        Locale.ENGLISH, ConceptNameType.FULLY_SPECIFIED)
                .answers(perinatalInfection,gestationalAge,lowBirthWeight,prematureBirth,centralNervousSystem,hydrocephalus,downsSyndrome,
                        cleftLipOrPalate,otherDevelopmentDelay,severeMalnutrition)
                .description("fe5c86fa-68e8-42f4-b762-8cccb0e621e5","Reason for referral (e.g PDC)",Locale.ENGLISH)
                .build());



    }
}
