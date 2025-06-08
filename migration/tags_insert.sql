CREATE TABLE tag (
    id BIGSERIAL  PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    skill VARCHAR(50) NOT NULL,
    category VARCHAR(100) NOT NULL,
    
    CONSTRAINT uq_tag_name_category UNIQUE (name, category)
);


-- Desenvolvimento
INSERT INTO tag (name, status, skill, category) VALUES ('Java', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Python', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('JavaScript', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('TypeScript', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('C#', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('HTML', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('CSS', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('SQL', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Node.js', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('React', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Angular', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Vue.js', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Spring Boot', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Django', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('.NET', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('REST API', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('GraphQL', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Docker', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Kubernetes', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('AWS', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Azure', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Git', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('CI/CD', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('Linux', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');
INSERT INTO tag (name, status, skill, category) VALUES ('WebSockets', 'ACTIVE', 'HARD_SKILL', 'DESENVOLVIMENTO');

-- Dados
INSERT INTO tag (name, status, skill, category) VALUES ('Excel Avançado', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Power BI', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Tableau', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('NoSQL', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('BigQuery', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('ETL', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Machine Learning', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Deep Learning', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Data Science', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Pandas', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('NumPy', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('R', 'ACTIVE', 'HARD_SKILL', 'DADOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Apache Spark', 'ACTIVE', 'HARD_SKILL', 'DADOS');

-- Cibersegurança
INSERT INTO tag (name, status, skill, category) VALUES ('Ethical Hacking', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('Pentest', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('Firewalls', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('SIEM', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('Gestão de Vulnerabilidades', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('Criptografia', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('Segurança da Informação', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');
INSERT INTO tag (name, status, skill, category) VALUES ('ISO 27001', 'ACTIVE', 'HARD_SKILL', 'CIBERSEGURANCA');

-- Design
INSERT INTO tag (name, status, skill, category) VALUES ('Adobe Photoshop', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Adobe Illustrator', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Figma', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Sketch', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Adobe XD', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('UI Design', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('UX Design', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Design Responsivo', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Edição de Vídeo', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('After Effects', 'ACTIVE', 'HARD_SKILL', 'DESIGN');
INSERT INTO tag (name, status, skill, category) VALUES ('Premiere', 'ACTIVE', 'HARD_SKILL', 'DESIGN');

-- Negócios
INSERT INTO tag (name, status, skill, category) VALUES ('Gestão de Projetos', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Scrum', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Kanban', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('PMBOK', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('OKRs', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('KPIs', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Análise de Negócios', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('ERP', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('CRM', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');
INSERT INTO tag (name, status, skill, category) VALUES ('Planejamento Estratégico', 'ACTIVE', 'HARD_SKILL', 'NEGOCIOS');

-- Marketing
INSERT INTO tag (name, status, skill, category) VALUES ('SEO', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Google Ads', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Meta Ads', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('E-mail Marketing', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Automação de Marketing', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Google Analytics', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Copywriting', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Inbound Marketing', 'ACTIVE', 'HARD_SKILL', 'MARKETING');
INSERT INTO tag (name, status, skill, category) VALUES ('Funil de Vendas', 'ACTIVE', 'HARD_SKILL', 'MARKETING');

-- Soft Skills (Geral)
INSERT INTO tag (name, status, skill, category) VALUES ('Comunicação', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Trabalho em Equipe', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Liderança', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Proatividade', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Criatividade', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Resolução de Problemas', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Pensamento Crítico', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Adaptabilidade', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Organização', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Inteligência Emocional', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Ética Profissional', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Gestão de Tempo', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Empatia', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Escuta Ativa', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Negociação', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Tomada de Decisão', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Foco em Resultados', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Colaboração', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Autoconhecimento', 'ACTIVE', 'SOFT_SKILL', 'GERAL');
INSERT INTO tag (name, status, skill, category) VALUES ('Resiliência', 'ACTIVE', 'SOFT_SKILL', 'GERAL');


